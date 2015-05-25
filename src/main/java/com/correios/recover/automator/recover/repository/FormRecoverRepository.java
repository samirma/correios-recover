
package com.correios.recover.automator.recover.repository;

import com.correios.recover.model.recover.FormRecoverData;
import java.util.List;


public interface FormRecoverRepository {

    void savePi(String piNumber, FormRecoverData recoverData);
    
    List<FormRecoverData> getFormRecoverDataToProcess();

}
