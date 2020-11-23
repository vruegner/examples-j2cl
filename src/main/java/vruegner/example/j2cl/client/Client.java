package vruegner.example.j2cl.client;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static elemental2.dom.DomGlobal.fetch;
import static elemental2.dom.DomGlobal.console;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import elemental2.core.Global;
import elemental2.dom.DomGlobal; 
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLElement;
import elemental2.dom.CSSProperties;
import elemental2.core.JSONType;
import elemental2.dom.Response;
import vruegner.example.j2cl.shared.Location;
import vruegner.example.j2cl.shared.Menu;

/**                                                                                                                                                                                             
 *  Copyright 2020 Volker Rügner
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
@JsType
public class Client {

	public static void startUI() {
		LocationWC.register();

		Client client = new Client();
		window.addEventListener("load", client::renderUI);
	}

	private void renderUI(Event pEvent) {
		HTMLElement page = (HTMLElement) document.createElement("div");
		page.style.marginTop = CSSProperties.MarginTopUnionType.of("96px");
		document.body.appendChild(page);

		page.appendChild(createClientExample());
		page.appendChild(createServerExample());

		page.style.display = "flex";
		page.style.justifyContent = "center";
	}

	private Element createClientExample() {
		Location loc = new Location();
		loc.name = "Client-Sushi";
		loc.type = "Sushi-Bar";
		loc.longitude = 43.823;
		loc.latitude = 24.529;
		Menu menu = new Menu();
		menu.name = "brunch menu";
		loc.menu = menu;
		
		LocationWC client_loc = new LocationWC();
		client_loc.style.marginRight = CSSProperties.MarginRightUnionType.of("96px");
		client_loc.setLocation(loc);

		return client_loc;
	}

	private Element createServerExample() {
		LocationWC server_page = new LocationWC();

		load(server_page);

		return server_page;
	}

	private void load(LocationWC server_page) {
		fetch("http://localhost:8080/examples-j2cl/rest/location")
       		.then(Response::json)
	        .then(data -> {
			console.log("JSON:" + data);
			Location loc = Js.cast(data);
			server_page.setLocation(loc);
               		return null;
       		})
       		.catch_(error -> {
                	console.log(error.toString());
                	return null;
            	});
	}

}
