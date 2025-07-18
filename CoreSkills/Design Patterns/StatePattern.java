/**
 * Problem: State Pattern (NeetCode Design Patterns)
 * Author: Steve Eckardt
 * Revision Date: July 18, 2025
 *
 * Description: Implements the State Design Pattern to manage the transitions between document states (Draft, Review, Published).
 *
 * Time Complexity: O(1) per `publish()` call — constant time state transitions
 * Space Complexity: O(1) — fixed number of states and no dynamic data structures
 */

// State interface for document status
interface State {
    void handleRequest(Document doc);
}

// Context class representing a document
class Document {
    private State state;
    private boolean isApproved;

    public Document() {
        this.state = new Draft(); // Default initial state
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // Trigger a transition based on current state
    public void publish() {
        this.state.handleRequest(this);
    }

    public void setApproval(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public boolean isApproved() {
        return this.isApproved;
    }
}

// Draft state: moves to Review
class Draft implements State {
    @Override
    public void handleRequest(Document doc) {
        doc.setState(new Review());
    }
}

// Review state: moves to Published if approved, otherwise back to Draft
class Review implements State {
    @Override
    public void handleRequest(Document doc) {
        if (doc.isApproved()) {
            doc.setState(new Published());
        } else {
            doc.setState(new Draft());
        }
    }
}

// Published state: final state — no further transitions
class Published implements State {
    @Override
    public void handleRequest(Document doc) {
        // No action — already published
    }
}
