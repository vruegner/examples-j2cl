package vruegner.example.j2cl.server;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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
 *
 *  Handler for REST requests.
 */
@Path("location")
public class RequestHandler {

    private Location location;

	public RequestHandler() {
		location = new Location();
		location.name = "Server-Sushi";
		location.type = "Sushi-Bar with booze";
		location.longitude = 61.475;
		location.latitude = 41.381;
		Menu menu = new Menu();
		menu.name = "dinner menu";
		location.menu = menu;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getLocation(@Context HttpServletRequest pRequest) {
	    return location.toJSON();
	}

}
