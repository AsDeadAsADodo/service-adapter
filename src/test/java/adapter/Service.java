package adapter;

import org.junit.Test;
import test.biz.HumanService;
import test.biz.HumanServiceImpl;
import test.pure.MyService;

/**
 * @Description:
 * @Author: EM
 * @CreateTime: 2019-08-16 14:38
 */
public class Service {


    @Test(expected = IllegalArgumentException.class)
    public void testPure(){
        ServiceAdapter serviceAdapter = new ServiceAdapterImpl("test.pure");
        System.out.println("------------signature list-----------");
        serviceAdapter.findAllServiceSignature().stream().forEach(e-> System.out.println(e));

        System.out.println("------------begin-----------------");

        MyService drink = (MyService)
                serviceAdapter.getSuitableService("drink");
        drink.doThings();
        MyService eat = (MyService)serviceAdapter.getSuitableService("eat");
        eat.doThings();
        MyService learn = (MyService)serviceAdapter.getSuitableService("learn");
        learn.doThings();



        // error
        MyService sleep = (MyService)serviceAdapter.getSuitableService("sleep");
        sleep.doThings();
    }

    @Test
    public void testBiz(){
        HumanService humanService = new HumanServiceImpl();
        humanService.receiveOrder("eat");
    }
}
