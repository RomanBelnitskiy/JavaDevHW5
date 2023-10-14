package org.example.model;

public class ProjectWorker {
    private long projectId;
    private long workerId;

    public ProjectWorker() {
    }

    public ProjectWorker(long projectId, long workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "ProjectWorker{" +
                "projectId=" + projectId +
                ", workerId=" + workerId +
                '}';
    }
}
