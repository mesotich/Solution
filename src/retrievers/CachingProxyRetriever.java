package retrievers;

import cache.LRUCache;
import storage.Storage;

public class CachingProxyRetriever implements Retriever {

    private final OriginalRetriever originalRetriever;
    private final LRUCache<Long, Object> lruCache;

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(10);
    }

    @Override
    public Object retrieve(long id) {
        Object value = lruCache.find(id);
        if (value != null)
            return value;
        value = originalRetriever.retrieve(id);
        if (value != null) {
            lruCache.set(id, value);
            return value;
        }
        return null;
    }
}
