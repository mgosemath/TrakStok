/*
 * Copyright 2013 JUGChennai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.jugchennai.javamoney.trakstok.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */
public class TSBaseFormBean implements Serializable {

    Logger logger;

    protected void doRedirect(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(url);
        } catch (Exception e) {
        }
    }

    private void addMessage(FacesMessage.Severity severity, String theMessage, String detail) {
        FacesMessage message = new FacesMessage(severity, theMessage, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    protected void addInfoMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    }

    protected void addErrorMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
    }

    protected void addWarningMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_WARN, summary, detail);
    }
}
