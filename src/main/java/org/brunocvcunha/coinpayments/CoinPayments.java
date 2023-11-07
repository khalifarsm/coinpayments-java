/**
 * Copyright (C) 2018 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.coinpayments;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsRequest;

import java.io.IOException;

/**
 * 
 * CoinPayments API
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@Builder
public class CoinPayments {

    @Getter
    @Setter
    private String publicKey;
    
    @Getter
    @Setter
    private String privateKey;

    @Getter
    @Setter
    protected HttpResponse lastResponse;

    @Getter
    @Setter
    protected CloseableHttpClient client;

    /**
     * Send request to endpoint
     * 
     * @param request
     *            Request object
     * @return success flag
     * @throws IOException
     * @throws ClientProtocolException
     */
    public <T> T sendRequest(CoinPaymentsRequest<T> request) throws ClientProtocolException, IOException {

        System.out.println("Sending request: " + request.getClass().getName());

        request.setApi(this);
        T response = request.execute();

        System.out.println("Result for " + request.getClass().getName() + ": " + response);

        return response;
    }


}