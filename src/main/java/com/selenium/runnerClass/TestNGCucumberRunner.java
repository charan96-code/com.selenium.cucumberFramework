package com.selenium.runnerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selenium.generalFunctionalities.Constants;
import com.selenium.generalFunctionalities.ExcelToObject;
import com.selenium.generalFunctionalities.ExcelValues;

import cucumber.api.testng.CucumberExceptionWrapper;
import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.FeatureResultListener;
import cucumber.api.testng.TestNgReporter;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import gherkin.formatter.Formatter;


public class TestNGCucumberRunner {

	private Runtime runtime;
	private RuntimeOptions runtimeOptions;
	private ResourceLoader resourceLoader;
	private FeatureResultListener resultListener;
	private ClassLoader classLoader;

	List<ExcelValues> listvals = ExcelToObject.readXlFile();

	public TestNGCucumberRunner(Class clazz) {
		classLoader = clazz.getClassLoader();	
		resourceLoader = new MultiLoader(classLoader);
		RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(clazz);
		runtimeOptions = runtimeOptionsFactory.create();
		TestNgReporter reporter = new TestNgReporter(System.out);
		ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
		resultListener = new FeatureResultListener(runtimeOptions.reporter(classLoader), runtimeOptions.isStrict());
		runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
	}

	public void runCucumber(CucumberFeature cucumberFeature) {

		String featureTag= cucumberFeature.getGherkinFeature().getName();

		for (ExcelValues excelValues : listvals) {
			if(featureTag.equalsIgnoreCase(excelValues.getTestCaseName())) {
				Constants.featureName = excelValues.getTestCaseName();
				Constants.description = excelValues.getDescription();
				Constants.executeStatus = excelValues.getExecuteStatus();
			}
		}

		resultListener.startFeature();
		cucumberFeature.run(runtimeOptions.formatter(classLoader),resultListener,runtime);
		if (!resultListener.isPassed()) {
			throw new CucumberException(resultListener.getFirstError());
		}
	}

	public void modifiedFeatureList() {
		List<ExcelValues> listvals2 = ExcelToObject.readXlFile();
		for(int j=0; j < listvals.size(); j++){
			if(j==0) {
				listvals2.clear();
			}

			if(listvals.get(j).getExecuteStatus().equals("Execute")) {
				listvals2.add(listvals.get(j));
			}
		}
		listvals.clear();
		listvals.addAll(listvals2);
		System.out.println(listvals);
	}

	public void finish() {
		Formatter formatter = runtimeOptions.formatter(classLoader);

		formatter.done();
		formatter.close();
		runtime.printSummary();
	}

	public List<CucumberFeature> getFeatures() {
		List<CucumberFeature> featurelist = runtimeOptions.cucumberFeatures(resourceLoader);
		List<CucumberFeature> metaDataLst = new ArrayList<>();

		Map<String,CucumberFeature> featuremap = getFeatureMap(featurelist);
		modifiedFeatureList();
		for (ExcelValues excelValues : listvals) {
			if(null!=featuremap.get(excelValues.getTestCaseName())) {
				metaDataLst.add(featuremap.get(excelValues.getTestCaseName()));
			}
		}
		return metaDataLst;
	}

	private Map<String, CucumberFeature> getFeatureMap(List<CucumberFeature> featurelist) {
		Map<String, CucumberFeature> featuremap = new HashMap<>();
		for(CucumberFeature cucumberFeature : featurelist) {
			featuremap.put(cucumberFeature.getGherkinFeature().getName(), cucumberFeature);
		}
		return featuremap;
	}

	public Object[][] provideFeatures() {
		try {
			List<CucumberFeature> features = getFeatures();
			List<Object[]> featuresList = new ArrayList<Object[]>(features.size());

			for(CucumberFeature feature: features) {
				featuresList.add(new Object[] {new CucumberFeatureWrapperImpl(feature)});
			}
			return featuresList.toArray(new Object[][]{});
		} catch (CucumberException e){
			return new Object[][] {new Object[] {new CucumberExceptionWrapper(e)}};
		}
	}
}