package ruisiyuan;

import com.xykj.business.controller.PersonController;

public class Test {
	public static void main(String[] args) {
		PersonController personController = (PersonController) SpringUtil.getObject("personController");
		System.out.println(personController);
    }
}
