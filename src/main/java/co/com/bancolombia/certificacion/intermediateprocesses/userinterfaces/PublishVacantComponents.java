package co.com.bancolombia.certificacion.intermediateprocesses.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PublishVacantComponents {

	public static final Target TXT_DATE_INITIAL_INTERNAL = Target.the("date inicial internal")
			.locatedBy("//table[@class='globalTable grid']/tbody/tr[2]/td[3]/input");
	public static final Target TXT_DATE_LIMIT_INTERNAL = Target.the("date limit internal")
			.locatedBy("//table[@class='globalTable grid']/tbody/tr[2]/td[5]/input");
	public static final Target TXT_DATE_INITIAL_EXTERNAL = Target.the("date inicial external")
			.locatedBy("//table[@class='globalTable grid']/tbody/tr[3]/td[3]/input");
	public static final Target TXT_DATE_LIMIT_EXTERNAL = Target.the("date limit external")
			.locatedBy("//table[@class='globalTable grid']/tbody/tr[3]/td[5]/input");
	public static final Target BTN_JOB_POSTING = Target.the("job posting button {0}").locatedBy(
			"//div[@class='contentTableWrapper']/table/tbody/tr[2]/td/div/div/div[2]/div/div/div/div/table/tbody/tr/td[1]/div/span//a[contains(text(),'{0}')]");
	public static final Target BTN_JOB_POSTING_INTERNAL = Target.the("job posting internal button")
			.locatedBy("//table[@class='globalTable grid']/tbody/tr[2]/td[9]/input");
	public static final Target BTN_JOB_POSTING_EXTERNAL = Target.the("job posting external button")
			.locatedBy("//table[@class='globalTable grid']/tbody/tr[3]/td[9]/input");

	private PublishVacantComponents() {
	}
}
