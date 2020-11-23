package vruegner.example.j2cl.shared;

import java.lang.StringBuffer;
import jsinterop.annotations.JsType;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsOverlay;

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
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Menu {

	public String name;


	@JsOverlay
	public final String toHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		return sb.toString();
	}

	@JsOverlay
	public final String toJSON() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"name\":\"" + name + "\"");
		sb.append("}");
		return sb.toString();
	}

	/*
	 * This is a toString method. Needed because native types do not allow overriding methods.
	 */
	@JsOverlay
	public final String toPrint() {
		StringBuffer sb = new StringBuffer();
		sb.append("Name: " + name);
		return sb.toString();
	}

}
