package vruegner.example.j2cl.client;

import elemental2.dom.HTMLElement;
import elemental2.dom.ShadowRoot;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Element;
import elemental2.dom.DomGlobal;
import jsinterop.annotations.JsType;
import jsinterop.annotations.JsConstructor;
import vruegner.example.j2cl.shared.Location;    

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
 *  Webcomponent for displaying a location.
 */
@JsType
public class LocationWC extends HTMLElement {

    private HTMLElement locationDiv;

    public static void register() {
        DomGlobal.customElements.define("wc-location", LocationWC.class);
    }

    @JsConstructor
    public LocationWC() {
	HTMLElement.AttachShadowOptionsType shadowOptions = HTMLElement.AttachShadowOptionsType.create();
       	shadowOptions.setMode("closed");
       	ShadowRoot shadow = attachShadow(shadowOptions);

        locationDiv = (HTMLElement) DomGlobal.document.createElement("div");
        shadow.appendChild(locationDiv);
    }

    public void setLocation(Location pLoc) {
	locationDiv.innerHTML = pLoc != null ? pLoc.toHTML() : "";
    }

}
