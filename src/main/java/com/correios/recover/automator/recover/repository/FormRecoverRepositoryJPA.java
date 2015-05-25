
package com.correios.recover.automator.recover.repository;

import com.correios.recover.model.recover.FormRecoverData;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FormRecoverRepositoryJPA implements FormRecoverRepository{

    @Override
    public void savePi(String piNumber, FormRecoverData recoverData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FormRecoverData> getFormRecoverDataToProcess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
