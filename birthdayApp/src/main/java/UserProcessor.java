import org.springframework.batch.item.ItemProcessor;

public class UserProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User item) throws Exception {
        return new User(item.getName(),item.getSurname(),item.getDateOfBirth());
    }
}
