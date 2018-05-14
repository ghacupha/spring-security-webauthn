package com.webauthn4j.test.platform;

import com.webauthn4j.attestation.authenticator.extension.Extension;
import com.webauthn4j.attestation.authenticator.extension.ExtensionIdentifier;
import com.webauthn4j.client.challenge.Challenge;
import com.webauthn4j.util.WIP;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@WIP
public class PublicKeyCredentialRequestOptions {

    private Challenge challenge;
    private long timeout;
    private String rpId;
    private List<PublicKeyCredentialDescriptor> allowCredentials;
    private UserVerificationRequirement userVerification;
    private Map<ExtensionIdentifier, Extension> extensions;

    public PublicKeyCredentialRequestOptions(Challenge challenge,
                                             long timeout,
                                             String rpId,
                                             List<PublicKeyCredentialDescriptor> allowCredentials,
                                             UserVerificationRequirement userVerification,
                                             Map<ExtensionIdentifier, Extension> extensions) {
        this.challenge = challenge;
        this.timeout = timeout;
        this.rpId = rpId;
        this.allowCredentials = allowCredentials;
        this.userVerification = userVerification;
        this.extensions = extensions;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public long getTimeout() {
        return timeout;
    }

    public String getRpId() {
        return rpId;
    }

    public List<PublicKeyCredentialDescriptor> getAllowCredentials() {
        return allowCredentials;
    }

    public UserVerificationRequirement getUserVerification() {
        return userVerification;
    }

    public Map<ExtensionIdentifier, Extension> getExtensions() {
        return extensions;
    }
}
