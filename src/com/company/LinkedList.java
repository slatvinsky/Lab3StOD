package com.company;

public class LinkedList<T> {
    Element<T> head;
    Element<T> tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        Element<T> current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void add(T value, int priority) {
        Element<T> t = new Element<>(value, priority, null, null);
        Element<T> current = head;
        if (tail == null && head == null) {head = t; tail = t; return;}
        while (current != null) {
            if (current.priority < priority) {
                insert(current, t);
                return;
            }
            current = current.getNext();
        }
        current = tail;
        tail = t;
        if (current != null) {
            current.setNext(t);
        } else {
            head = t;
        }
        t.setPrevious(current);
    }

    public void insert(Element<T> next, Element<T> toInsert) {
        Element<T> previous = next.getPrevious();
        if (previous != null) {
            previous.setNext(toInsert);
        } else head = toInsert;
        next.setPrevious(toInsert);
        toInsert.setPrevious(previous);
        toInsert.setNext(next);
    }

    public T removeFirst() {
        if (isEmpty()) {System.out.println("Список пуст!"); return null;}
        T data = head.getData();
        head = head.getNext();
        head.setPrevious(null);
        return data;
    }

    public void showList() {
        Element<T> current = head;
        while (current!=null) {
            current.showElement();
            current = current.getNext();
        }
    }

    public void clear() {
        Element<T> current = head;
        Element<T> next;
        while (current != null) {
            current.prev = null;
            next = current.getNext();
            current.next = null;
            current = next;
        }
    }
}
