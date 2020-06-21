package domain;

import command.Modification;
import observer.Observer;
import java.util.*;

public class User {
    private Set<Wardrobe> wardrobes;
    private List<Modification> pendingModifications;
    private List<Modification> executeModifications;
    private Set<Attire> dailySuggestions;
    private List<Observer> observers;
    private String emailAddress;

    public User(String emailAddress) {
        this.wardrobes = new HashSet<>();
        this.dailySuggestions = new HashSet<>();
        this.pendingModifications = new ArrayList<>();
        this.executeModifications = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.emailAddress = emailAddress;
    }

    public Set<Wardrobe> getWardrobes() {
        return wardrobes;
    }

    public void addWardrobe(Wardrobe wardrobe) {
        wardrobes.add(wardrobe);
    }

    public void addPendingModification(Modification modification) {
        pendingModifications.add(modification);
    }

    public void removePendingModification(Modification modification) {
        pendingModifications.remove(modification);
    }

    public void executeModification(Modification modification) {
        modification.apply(this);
        this.pendingModifications.remove(modification);
        this.executeModifications.add(modification);
    }

    public void addGarmentToWardrobe(Wardrobe wardrobe, Garment garment) {
        wardrobe.addGarment(garment);
    }

    public void removeGarmentToWardrobe(Wardrobe wardrobe, Garment garment) {
        wardrobe.removeGarment(garment);
    }

    public void undoAcceptedModifications() {
        this.executeModifications.forEach(executeModification -> executeModification.undo(this));
        this.executeModifications.clear();
    }

    public void setDailySuggestions(Set<Attire> attires) {
        dailySuggestions = attires;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void weatherAlertWasGenerated(List<String> alerts) {
        this.observers.forEach(observer -> observer.weatherAlertGenerated(this, alerts));
    }
}
