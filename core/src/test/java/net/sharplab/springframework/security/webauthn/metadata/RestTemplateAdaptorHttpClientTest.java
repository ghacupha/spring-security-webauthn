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

package net.sharplab.springframework.security.webauthn.metadata;


import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RestTemplateAdaptorHttpClientTest {

    @Test
    public void fetch_test() {
        String url = "https://example.com/webauthn/options";
        RestTemplate restTemplate = mock(RestTemplate.class);
        when(restTemplate.getForObject(eq(url), eq(String.class))).thenReturn("response");
        RestTemplateAdaptorHttpClient httpClient = new RestTemplateAdaptorHttpClient(restTemplate);
        httpClient.fetch(url);
        verify(restTemplate).getForObject(eq(url), eq(String.class));
    }

}