package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private final List<TodoItem> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            String trimmed = item.trim();
            if (!trimmed.isEmpty()) {
                items.add(new TodoItem(trimmed));
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).markDone();
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }

    public List<TodoItem> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String lowerQuery = query.trim().toLowerCase();
        return items.stream()
                .filter(item -> item.getText().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
    }

    public List<TodoItem> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }
}