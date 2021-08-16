package br.com.cleanhouse.service.announcements;

public interface Announcement<T> {
    void createAnnouncement(T value);
}
