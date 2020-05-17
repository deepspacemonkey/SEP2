package dk.grouptwo.networking;

import dk.grouptwo.model.ModelManager;
import dk.grouptwo.model.objects.Job;
import dk.grouptwo.networking.remote.RemoteEmployerClient;
import dk.grouptwo.utility.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EmployerClient implements RemoteEmployerClient, PropertyChangeSubject {
    private PropertyChangeSupport property;

    public EmployerClient() {
        property = new PropertyChangeSupport(this);
    }

    @Override
    public void updateJob(Job job) {
        property.firePropertyChange("updateJob", 0, job);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);

    }

    @Override
    public void addListener(String eventID, PropertyChangeListener listener) {
        property.addPropertyChangeListener(eventID, listener);
    }

    @Override
    public void removeListener(String eventID, PropertyChangeListener listener) {
        property.removePropertyChangeListener(eventID, listener);
    }
}