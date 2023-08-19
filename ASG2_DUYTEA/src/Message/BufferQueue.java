package Message;
import java.util.ArrayList;
import java.util.List;
class BufferQueue {
    private List<Message> queue;

    public BufferQueue() {
        queue = new ArrayList<>();
    }

    public void enqueueMessage(Message message) {
        queue.add(message);
    }

    public Message dequeueMessage() {
        ensureNonEmpty();
        return queue.remove(0);
    }

    public int size() {
        return queue.size();
    }

    public void ensureNonEmpty() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is Empty !!");
        }
    }
}


