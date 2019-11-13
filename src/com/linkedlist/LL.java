package com.linkedlist;

class LL<T> {
    private Node<T> root = null;
    private int size = 0;

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        int l = 0;
        Node<T> temp = this.root;

        while (l < index) {
            temp = temp.next;
            l++;
        }

        return temp.value;
    }

    public void delete(int index) {
        if (index == 0) {
           root = root.next;
           size--;
           return;
        }

        Node<T> temp = this.root;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public void add(int index, T value) {
        //indice maior que o tamanho
        if (index > size) {
            return;
        }

        Node<T> newNode = new Node<>(value);

        //indice 0
        if (index == 0) {
            newNode.next = this.root;
            root = newNode;
            size++;
            return;
        }

        //outros indices
        Node<T> current = this.root;
        Node<T> previous = this.root;

        for (int i = 0; i < index; i++) {
            if (current != null) {
                previous = current;
                current = current.next;
            }
        }

        if (current == null) {
            previous.next = newNode;
        } else {
            newNode.next = current;
            previous.next = newNode;
        }

        size++;
    }

    public void add(T value) {
        if (root == null) {
            this.root = new Node<>(value);
            size++;
        } else {
            Node<T> temp = this.root;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node<>(value);
            size++;
        }
    }

    public String toString() {
        return root + " ";
    }

    public static void main(String[] args) {
        LL<Integer> l = new LL<>();
        l.add(1);
        l.add(10);
        l.add(100);
        l.add(1000);
        l.add(0, 5);
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        System.out.println(l.get(4));

        System.out.println();

        l.delete(0);
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
    }
}