package test.pure;

/**
 * @Description:
 * @Author: EM
 * @CreateTime: 2019-08-16 14:41
 */
public final class DrinkService implements MyService {
    @Override
    public void doThings() {
        System.out.println("i want drink something");
    }

    @Override
    public String getSignature() {
        return "drink";
    }
}
