package cache;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LRUCache<K, V> {
  static class CacheNode<K, V> {
    K key;
    V value;
    CacheNode<K, V> prev, next;

    public CacheNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private HashMap<K, CacheNode<K, V>> map;
  private final int capacity;
  private int size;
  private CacheNode<K, V> phantomHead;
  private CacheNode<K, V> phantomTail;

  public LRUCache(int capacity) {
    this.map = new HashMap<>(capacity);
    this.capacity = capacity;
    this.size = 0;
    this.phantomHead = new CacheNode<>(null, null);
    this.phantomTail = new CacheNode<>(null, null);
    phantomHead.next = phantomTail;
    phantomTail.next = phantomHead;
  }

  public V get(K key) {
    CacheNode<K, V> node = map.get(key);
    if (node == null) return null;
    moveToHead(node);
    return node.value;
  }

  public void put(K key, V value) {
    CacheNode<K, V> node = map.get(key);
    if (node != null) {
      node.value = value;
      moveToHead(node);
    } else {
      if (size == capacity) {
        // remove tail
        CacheNode<K, V> actualTail = phantomTail.prev;
        removeNode(actualTail);
        map.remove(actualTail.key);
        size--;
      }

      CacheNode<K, V> newNode = new CacheNode<>(key, value);
      map.put(key, newNode);
      addNodeToHead(newNode);
      size++;
    }
  }

  private void moveToHead(CacheNode<K, V> node) {
    removeNode(node);
    addNodeToHead(node);
  }

  private void addNodeToHead(CacheNode<K, V> node) {
    node.prev = phantomHead;
    node.next = phantomHead.next;

    phantomHead.next.prev = node;
    phantomHead.next = node;
  }

  private void removeNode(CacheNode<K, V> node) {
    CacheNode<K, V> prev = node.prev;
    CacheNode<K, V> next = node.next;
    prev.next = next;
    next.prev = prev;
  }
}
