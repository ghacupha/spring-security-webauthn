/*
 * Copyright 2002-2018 the original author or authors.
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

package com.webauthn4j.attestation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webauthn4j.attestation.authenticator.WebAuthnAuthenticatorData;
import com.webauthn4j.attestation.statement.WebAuthnAttestationStatement;

import java.io.Serializable;
import java.util.Objects;

public class WebAuthnAttestationObject implements Serializable {

    //~ Instance fields ================================================================================================
    @JsonProperty("authData")
    private WebAuthnAuthenticatorData AuthenticatorData;

    @JsonProperty("attStmt")
    private WebAuthnAttestationStatement attestationStatement; //TODO: generalize


    public WebAuthnAuthenticatorData getAuthenticatorData() {
        return AuthenticatorData;
    }

    public void setAuthenticatorData(WebAuthnAuthenticatorData webAuthnAuthenticatorData) {
        this.AuthenticatorData = webAuthnAuthenticatorData;
    }

    @JsonProperty("fmt")
    public String getFormat() {
        return attestationStatement.getFormat();
    }

    public WebAuthnAttestationStatement getAttestationStatement() {
        return attestationStatement;
    }

    public void setAttestationStatement(WebAuthnAttestationStatement attestationStatement) {
        this.attestationStatement = attestationStatement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebAuthnAttestationObject that = (WebAuthnAttestationObject) o;
        return Objects.equals(AuthenticatorData, that.AuthenticatorData) &&
                Objects.equals(attestationStatement, that.attestationStatement);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AuthenticatorData, attestationStatement);
    }
}