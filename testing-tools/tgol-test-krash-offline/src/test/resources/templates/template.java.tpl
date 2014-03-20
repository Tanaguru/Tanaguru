#set($class.package = 'org.opens.tanaguru.webapp.test')
#set($testPrefix = 'Test')
#set($name = $model.name.replace('-', '_'))
#set($class.name = "$name$testPrefix")

package $class.package;
import org.opens.tanaguru.webapp.test.data.KrashtestResult;

public class $class.name extends AbstractTanaguruOnlineTest {

    private String siteName = "$model.name";
    private String[] url = {"$model.url"};

    /**
     * Default constructor
     */
    public $class.name (){
        super();
    }

    public void testKrashtestWebappResult(){
        assertEquals(KrashtestResult.SUCCESS.toString(), computeWebappResult(
                launchTanaguru(siteName, url, false)));
    }

}