package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item.
 * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
 * the least recently used key would be evicted.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * @param <K>
 * @param <V>
 */
public class LFUCache<K, V> {
  static class CacheNode<K, V> {
    K key;
    V value;
    int accessCount;
    CacheNode<K, V> prev, next;

    CacheNode(K key, V value) {
      this.key = key;
      this.value = value;
      this.accessCount = 0;
    }
  }

  static class DoublyLinkedList<K, V> {
    CacheNode<K, V> phantomHead, phantomTail;
    int size;

    DoublyLinkedList() {
      this.size = 0;
      this.phantomHead = new CacheNode<>(null, null);
      this.phantomTail = new CacheNode<>(null, null);
      phantomHead.next = phantomTail;
      phantomTail.prev = phantomHead;
    }

    /**
     * Add the given node to the head of the list
     */
    void add(CacheNode<K, V> node) {
      node.next = phantomHead.next;
      node.prev = phantomHead;

      phantomHead.next.prev = node;
      phantomHead.next = node;

      size++;
    }

    /**
     * Remove the given node from the linked list
     */
    void remove(CacheNode<K, V> node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;

      size--;
    }

    CacheNode<K, V> popLast() {
      if (size == 0) return null;
      CacheNode<K, V> last = phantomTail.prev;
      remove(last);
      return last;
    }
  }

  private final Map<Integer, DoublyLinkedList<K, V>> countMap;
  private final Map<K, CacheNode<K, V>> cache;
  private final int capacity;
  private int minimumAccessCount;
  private int size;

  public LFUCache(int capacity) {
    this.cache = new HashMap<>(capacity);
    this.countMap = new HashMap<>();
    this.capacity = capacity;
    this.size = 0;
    this.minimumAccessCount = 0;
  }

  public V get(K key) {
    CacheNode<K, V> node = cache.get(key);
    if (node == null) return null;
    incrementAccessCount(node);
    return node.value;
  }

  public void put(K key, V value) {
    CacheNode<K, V> node = cache.get(key);
    if (node != null) {
      node.value = value;
      incrementAccessCount(node);
    } else {
      if (size == capacity) {
        DoublyLinkedList<K, V> minimumAccessList = countMap.get(minimumAccessCount);
        CacheNode<K, V> leastFrequentlyAccessedNode = minimumAccessList.popLast();
        cache.remove(leastFrequentlyAccessedNode.key);
        size--;
      }
      minimumAccessCount = 0;
      CacheNode<K, V> newNode = new CacheNode<>(key, value);
      DoublyLinkedList<K, V> accessCountList = countMap.getOrDefault(newNode.accessCount, new DoublyLinkedList<>());
      accessCountList.add(newNode);
      countMap.put(newNode.accessCount, accessCountList);
      cache.put(key, newNode);
      size++;
    }
  }

  private void incrementAccessCount(CacheNode<K, V> node) {
    int oldAccessCount = node.accessCount;
    int newAccessCount = oldAccessCount + 1;
    node.accessCount = newAccessCount;
    DoublyLinkedList<K, V> oldList = countMap.get(oldAccessCount);
    oldList.remove(node);
    DoublyLinkedList<K, V> newList = countMap.getOrDefault(newAccessCount, new DoublyLinkedList<>());
    newList.add(node);
    countMap.put(newAccessCount, newList);

    if (oldList.size == 0 && minimumAccessCount == oldAccessCount) minimumAccessCount++;
  }
}
