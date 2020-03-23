package cfh.logikus;

import static java.util.Objects.*;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class ContactGroup extends JComponent {

    private final Settings settings = Settings.INSTANCE;
    
    private final List<Contact> contacts;
    
    public ContactGroup(Orient orient) {
        requireNonNull(orient);
        
        this.contacts = List.of(new Contact(), new Contact(), new Contact());

        var border = settings.groupBorder();
        setBorder(BorderFactory.createEmptyBorder(border, border, border, border));
        setLayout(switch (orient) {
            case HORIZONTAL -> new GridLayout(1, 0);
            case VERTICAL   -> new GridLayout(0, 1);
        });
        contacts.forEach(this::add);
    }
}
