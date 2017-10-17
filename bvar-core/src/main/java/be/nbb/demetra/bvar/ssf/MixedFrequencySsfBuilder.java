/*
 * Copyright 2016 National Bank of Belgium
 * 
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved 
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and 
 * limitations under the Licence.
 */
package be.nbb.demetra.bvar.ssf;

import ec.demetra.ssf.implementations.var.VarDescriptor;
import ec.tstoolkit.timeseries.simplets.TsData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Palate
 */
public class MixedFrequencySsfBuilder {
    
    private final List<TsData> input=new ArrayList<>();
    private VarDescriptor desc;
    
    public boolean set(TsData[] data, VarDescriptor desc){
        if (desc.getVariablesCount() != data.length)
            return false;
        for (int i=0; i<data.length; ++i){
            input.add(data[i]);
        }
        this.desc=desc;
        return true;
    }
    
}
