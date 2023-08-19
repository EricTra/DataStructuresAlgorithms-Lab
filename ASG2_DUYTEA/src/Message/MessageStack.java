package Message;

import Message.Message;

import java.util.ArrayList;
import java.util.List;
class MessageStack {
    private List<Message> stack;

    public MessageStack() {
        stack = new ArrayList<>();
    }

    public void pushMessage(Message message) {
        stack.add(message);
    }

    public Message popMessage() {
        if (!isEmpty()) {
            int lastIndex = stack.size() - 1;
            Message message = stack.get(lastIndex);
            stack.remove(lastIndex);
            return message;
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
