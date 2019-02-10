/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sharplab.springframework.security.webauthn.options;

import com.webauthn4j.request.PublicKeyCredentialParameters;
import com.webauthn4j.request.PublicKeyCredentialRpEntity;
import com.webauthn4j.request.PublicKeyCredentialType;
import com.webauthn4j.request.extension.client.AuthenticationExtensionsClientInputs;
import com.webauthn4j.response.attestation.statement.COSEAlgorithmIdentifier;
import com.webauthn4j.response.client.challenge.Challenge;
import com.webauthn4j.response.client.challenge.DefaultChallenge;
import com.webauthn4j.util.Base64UrlUtil;
import net.sharplab.springframework.security.webauthn.endpoint.Parameters;
import net.sharplab.springframework.security.webauthn.endpoint.WebAuthnPublicKeyCredentialUserEntity;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionOptionsTest {

    @Test
    public void equals_hashCode_test(){
        Challenge challenge = new DefaultChallenge();
        BigInteger authenticationTimeout = BigInteger.valueOf(1000);
        String rpId = "localhost";
        List<String> credentialIds = Collections.singletonList("credentialId");
        AuthenticationExtensionsClientInputs authenticationExtensionsClientInputs = new AuthenticationExtensionsClientInputs();
        Parameters parameters = new Parameters(
                "username",
                "password",
                "credentialId",
                "clientDataJSON",
                "authenticatorData",
                "signature",
                "clientExtensionsJSON");
        AssertionOptions instanceA = new AssertionOptions(challenge, authenticationTimeout, rpId, credentialIds, authenticationExtensionsClientInputs, parameters);
        AssertionOptions instanceB = new AssertionOptions(challenge, authenticationTimeout, rpId, credentialIds, authenticationExtensionsClientInputs, parameters);

        assertThat(instanceA).isEqualTo(instanceB);
        assertThat(instanceA).hasSameHashCodeAs(instanceB);
    }
}