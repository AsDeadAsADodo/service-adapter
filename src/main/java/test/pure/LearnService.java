package test.pure;

/**
 * @Description:
 * @Author: EM
 * @CreateTime: 2019-08-16 15:08
 */
public final class LearnService implements MyService {
    @Override
    public void doThings() {
        System.out.println("i learned something today");
    }

    @Override
    public String getSignature() {
        return "learn";
    }
}
