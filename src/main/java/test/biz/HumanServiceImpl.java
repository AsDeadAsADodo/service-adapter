package test.biz;

import adapter.ServiceAdapter;
import adapter.ServiceAdapterImpl;
import test.pure.MyService;

/**
 * @Description:
 * @Author: EM
 * @CreateTime: 2019-08-16 15:19
 */
public class HumanServiceImpl implements HumanService {
    @Override
    public void receiveOrder(String order) {
        System.out.println("----------analyzed-------------");
        analyzedOrderAndDo(order);

        System.out.println("----------find suitable service ----");
        getSuitableServiceAndDo(order);
    }

    private void getSuitableServiceAndDo(String order) {
        long start = System.currentTimeMillis();
        ServiceAdapter serviceAdapter = new ServiceAdapterImpl("test.pure");
        MyService myService = (MyService) serviceAdapter.getSuitableService(order);
        myService.doThings();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private void analyzedOrderAndDo(String order) {
        long start = System.currentTimeMillis();
        if ("eat".equals(order)) {
            eat();
        } else if ("learn".equals(order)) {
            learn();
        } else if ("speak".equals(order)) {
            speak();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //......

        /*
        switch (order) {
            case "eat":{
                eat();
                break;
            }
            case "learn":{
                learn();
                break;
            }
            case "speak":{
                speak();
                break;
            }
            //......
            default:{

            }
        }
        */
    }

    public void eat() {
        System.out.println("i eat");
    }

    public void learn() {
        System.out.println("i learn");
    }

    public void speak() {
        System.out.println("i speak");
    }
    // ...
}
