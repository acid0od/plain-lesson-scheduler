/*
 * Copyright 2012-2014 the original author or authors.
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
package net.odtel.timeboard;

import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.CassandraUnitTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.context.TestExecutionListeners.MergeMode.REPLACE_DEFAULTS;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestExecutionListeners(listeners = {
        CassandraUnitDependencyInjectionTestExecutionListener.class,
        CassandraUnitTestExecutionListener.class,
        ServletTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class
},
        mergeMode = REPLACE_DEFAULTS)
@EmbeddedCassandra(timeout = 60000)
public class HelloWorldConfigurationTests {

    private static final String TIMEPLAN_POINT = "/timeplan/";
    private static final String TIMEPLAN_POINT_API = "/timeplan/api/";
    private static final String HTTP_LOCALHOST = "http://localhost:";

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGreeting() {
        ResponseEntity<String> entity = restTemplate
                .getForEntity(HTTP_LOCALHOST + this.port + TIMEPLAN_POINT, String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

 /*   @Test
    public void testPost() {
        ResumePointItem resumePointItem = createResumePointItem("accountId", "deviceId");

        ResponseEntity<Void> entity = restTemplate.postForEntity(HTTP_LOCALHOST + this.port + TIMEPLAN_POINT_API, resumePointItem, Void.class);

        assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    }

    @Test
    public void testGet() {
        String accountId = "accountId_" + System.currentTimeMillis();
        String deviceId = "deviceId_" + System.currentTimeMillis();
        ResumePointItem resumePointItem = createResumePointItem(accountId, deviceId);

        ResponseEntity<Void> entity = restTemplate.postForEntity(HTTP_LOCALHOST + this.port + TIMEPLAN_POINT_API, resumePointItem, Void.class);

        assertEquals(HttpStatus.CREATED, entity.getStatusCode());

        ResponseEntity<ResumePointItem> forEntity = restTemplate.getForEntity(HTTP_LOCALHOST + this.port + TIMEPLAN_POINT_API + accountId + "/" + resumePointItem.getEntityId() + "/",
                ResumePointItem.class);

        assertEquals(HttpStatus.OK, forEntity.getStatusCode());

        assertEquals(deviceId, forEntity.getBody().getDeviceId());
    }

    private ResumePointItem createResumePointItem(String accountId, String deviceId) {
        UUID id = UUIDs.timeBased();

        ResumePointItem resumePointItem = new ResumePointItem();
        resumePointItem.setAccountId(accountId);
        resumePointItem.setEntityId(id.toString());
        resumePointItem.setDeviceId(deviceId);
        return resumePointItem;
    }
*/

}
