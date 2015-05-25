/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.correios.recover.automator.recover.repository;

import com.correios.recover.CorreiosRecoverApplication;
import com.correios.recover.automator.recover.FormRecoverService;
import com.correios.recover.model.recover.FormRecoverData;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CorreiosRecoverApplication.class)
public class FormRecoverRepositoryJPATest {

    @Autowired
    private FormRecoverService formRecoverService;

    @Before
    public void setUp() {
        FormRecoverRepository repository = mock(FormRecoverRepository.class);

        when(repository.getFormRecoverDataToProcess()).thenReturn(null);

        // Inject mock into private field:
        ReflectionTestUtils.setField(formRecoverService, "repository", repository);

    }

    @Test
    public void testSavePi() {

    }

    @Test
    public void testGetFormRecoverDataToProcess() {
        final List<FormRecoverData> list = formRecoverService.getList();
        assertNull(list);
    }

}
