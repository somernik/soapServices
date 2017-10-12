package gov.weather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by sarah on 10/12/2017.
 */
public class NdfdXMLBindingStubTest {

    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53704"); // creates XML string

        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // this will create Java object from the XML string
        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result)); // use this because we have a string and not a file

        assertEquals("Result did not match", "43.0798,-89.3875", dwml.getLatLonList());
    }
}
