/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package pl.skawanna.webapp;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;

import pl.skawanna.service.AnnaService;
import pl.skawanna.spring.SpringContextHelper;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
// @Configurable
public class MyVaadinApplication extends Application {
	private Window window;

	//
	// @Autowired
	// AnnaService service;

	@Override
	public void init() {
		SpringContextHelper helper = new SpringContextHelper(this);
		final AnnaService service = (AnnaService) helper.getBean("service");

		window = new Window("My Vaadin Application");
		setMainWindow(window);
		Button button = new Button("Click Me");
		button.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				window.addComponent(new Label("Thank you for clicking"));
				window.addComponent(new Label(service.hello()));
			}
		});
		window.addComponent(button);

	}

}
