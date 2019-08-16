package test.pure;

/**
 * @Description:
 * @Author: EM
 * @CreateTime: 2019-08-16 14:40
 */
public final class EatService implements MyService {
    @Override
    public void doThings() {
        System.out.println("i want eat something");
    }

    @Override
    public String getSignature() {
        return "eat";
    }
}
