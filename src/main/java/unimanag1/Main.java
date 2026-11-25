package unimanag1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// ==========================================
// 1. ABSTRACT CLASSES (ABSTRACTION)
// ==========================================

abstract class Person {
    protected int id;
    protected String name;
    protected String email;
    protected UserAccount account;

    public Person(int id, String name, String email, UserAccount account) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public abstract String getRoleTitle();

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public UserAccount getAccount() { return account; }

    @Override
    public String toString() {
        return name + " (" + getRoleTitle() + ")";
    }
}

abstract class BaseFrame extends JFrame {
    protected static final String AUTHOR_CREDIT = "Built by Muhammad Mujtaba Bashar (FA25-BSE-148)";

    protected final Color bgOffWhite = new Color(244, 247, 251);
    protected final Color cardWhite = Color.WHITE;
    protected final Color primaryNavy = new Color(20, 46, 84);
    protected final Color accentBlue = new Color(37, 99, 235);
    protected final Color successGreen = new Color(22, 130, 74);
    protected final Color dangerRed = new Color(185, 38, 38);
    protected final Color mutedText = new Color(90, 102, 120);
    protected final Color borderGray = new Color(214, 222, 234);

    protected final Font fontTitle = new Font("Segoe UI", Font.BOLD, 20);
    protected final Font fontSubtitle = new Font("Segoe UI", Font.PLAIN, 13);
    protected final Font fontLabel = new Font("Segoe UI", Font.BOLD, 13);
    protected final Font fontButton = new Font("Segoe UI", Font.BOLD, 13);
    protected final Font fontTable = new Font("Segoe UI", Font.PLAIN, 13);
    protected final Font fontTableHeader = new Font("Segoe UI", Font.BOLD, 13);

    public BaseFrame(String title, int width, int height) {
        super(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgOffWhite);
    }

    protected void initUI() {
        JPanel rootPanel = new JPanel(new BorderLayout(0, 10));
        rootPanel.setBackground(bgOffWhite);
        rootPanel.setBorder(new EmptyBorder(16, 20, 12, 20));

        rootPanel.add(createMainPanel(), BorderLayout.CENTER);
        rootPanel.add(createFooterPanel(), BorderLayout.SOUTH);

        setContentPane(rootPanel);
    }

    protected abstract JPanel createMainPanel();

    protected JPanel createFooterPanel() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(bgOffWhite);
        footer.setBorder(new EmptyBorder(4, 4, 0, 4));

        JLabel creditLabel = new JLabel(AUTHOR_CREDIT);
        creditLabel.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        creditLabel.setForeground(mutedText);

        JLabel appLabel = new JLabel("UniManag v1.0");
        appLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        appLabel.setForeground(mutedText);

        footer.add(creditLabel, BorderLayout.WEST);
        footer.add(appLabel, BorderLayout.EAST);
        return footer;
    }

    protected JPanel createCardPanel(LayoutManager layout) {
        JPanel card = new JPanel(layout);
        card.setBackground(cardWhite);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderGray, 1, true),
                new EmptyBorder(16, 18, 16, 18)
        ));
        return card;
    }

    protected JButton createStyledButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(fontButton);
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(new EmptyBorder(10, 16, 10, 16));
        return btn;
    }

    protected void styleTable(JTable table) {
        table.setFont(fontTable);
        table.setRowHeight(28);
        table.setGridColor(borderGray);
        table.setSelectionBackground(new Color(219, 234, 254));
        table.setSelectionForeground(primaryNavy);
        table.setFillsViewportHeight(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(fontTableHeader);
        header.setBackground(primaryNavy);
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(header.getWidth(), 34));
    }

    public void refreshData() {
        // Optional override in subclasses
    }
}

// ==========================================
// 2. CONCRETE MODEL CLASSES
// ==========================================

class Address {
    private String street, city, state, zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zip;
    }
}

class UserAccount {
    private int userId;
    private String username, password, role;

    public UserAccount(int userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login(String u, String p) {
        return username.equalsIgnoreCase(u.trim()) && password.equals(p.trim());
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}

class Department {
    private int deptId;
    private String name, building;

    public Department(int deptId, String name, String building) {
        this.deptId = deptId;
        this.name = name;
        this.building = building;
    }

    public int getDeptId() { return deptId; }
    public String getName() { return name; }
    public String getBuilding() { return building; }

    @Override
    public String toString() { return name; }
}

class Course {
    private int courseId;
    private String title;
    private int credits;
    private Department department;

    public Course(int courseId, String title, int credits, Department department) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.department = department;
    }

    public int getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public Department getDepartment() { return department; }

    @Override
    public String toString() { return title; }
}

class Professor extends Person {
    private Department department;

    public Professor(int id, String name, String email, Department department, UserAccount account) {
        super(id, name, email, account);
        this.department = department;
    }

    @Override
    public String getRoleTitle() {
        return "Faculty - " + department.getName();
    }

    public Department getDepartment() { return department; }
}

final class Grade {
    private int gradeId, studentId;
    private Course course;
    private float score;
    private String gradeLetter;

    public Grade(int gradeId, int studentId, Course course, float score) {
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.course = course;
        setScore(score);
    }

    public void setScore(float score) {
        this.score = score;
        if (score >= 90) gradeLetter = "A";
        else if (score >= 80) gradeLetter = "B";
        else if (score >= 70) gradeLetter = "C";
        else if (score >= 60) gradeLetter = "D";
        else gradeLetter = "F";
    }

    public int getGradeId() { return gradeId; }
    public int getStudentId() { return studentId; }
    public Course getCourse() { return course; }
    public float getScore() { return score; }
    public String getGradeLetter() { return gradeLetter; }
}

class Transcript {
    private int transcriptId;
    private Student student;
    private ArrayList<Grade> grades = new ArrayList<>();

    public Transcript(int transcriptId, Student student) {
        this.transcriptId = transcriptId;
        this.student = student;
    }

    public void addGrade(Grade g) { grades.add(g); }
    public ArrayList<Grade> getGrades() { return grades; }
}

class Student extends Person {
    private String phone;
    private Address address;
    private Transcript transcript;
    private int totalClasses = 15;
    private int attendedClasses = 13;

    public Student(int id, String name, String email, String phone, Address address, UserAccount account) {
        super(id, name, email, account);
        this.phone = phone;
        this.address = address;
        this.transcript = new Transcript(id + 1000, this);
    }

    @Override
    public String getRoleTitle() {
        return "Undergraduate Student";
    }

    public void markAttendance(boolean present) {
        this.totalClasses++;
        if (present) this.attendedClasses++;
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) return 100.0;
        return ((double) attendedClasses / totalClasses) * 100.0;
    }

    public String getPhone() { return phone; }
    public Address getAddress() { return address; }
    public Transcript getTranscript() { return transcript; }
}

class Assessment {
    private int id;
    private String title, type;
    private Course course;
    private float totalMarks;

    public Assessment(int id, String title, String type, Course course, float totalMarks) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.course = course;
        this.totalMarks = totalMarks;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public Course getCourse() { return course; }
    public float getTotalMarks() { return totalMarks; }
}

class AssessmentRecord {
    private int recordId;
    private Student student;
    private Assessment assessment;
    private float obtainedMarks;
    private String status;

    public AssessmentRecord(int recordId, Student student, Assessment assessment, float obtainedMarks, String status) {
        this.recordId = recordId;
        this.student = student;
        this.assessment = assessment;
        this.obtainedMarks = obtainedMarks;
        this.status = status;
    }

    public void updateMarks(float marks) {
        this.obtainedMarks = marks;
        this.status = "Graded";
    }

    public int getRecordId() { return recordId; }
    public Student getStudent() { return student; }
    public Assessment getAssessment() { return assessment; }
    public float getObtainedMarks() { return obtainedMarks; }
    public String getStatus() { return status; }
}

// ==========================================
// 3. DATA STORE SERVICE (SINGLETON & STORAGE)
// ==========================================

class StudentRepository {
    private ArrayList<Student> list = new ArrayList<>();

    public void add(Student item) { list.add(item); }
    public List<Student> getAll() { return list; }

    public Student findById(int id) {
        for (Student s : list) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}

class DataStore {
    private static DataStore instance;

    public StudentRepository studentRepo = new StudentRepository();
    public ArrayList<Person> allPeople = new ArrayList<>();

    public ArrayList<Professor> professors = new ArrayList<>();
    public ArrayList<Department> departments = new ArrayList<>();
    public ArrayList<Course> courses = new ArrayList<>();
    public ArrayList<Grade> grades = new ArrayList<>();
    public ArrayList<Assessment> assessments = new ArrayList<>();
    public ArrayList<AssessmentRecord> records = new ArrayList<>();

    private DataStore() {
        Department cs = new Department(1, "Software Engineering", "Main Block");
        departments.add(cs);

        Course oop = new Course(101, "Object-Oriented Programming", 3, cs);
        Course ict = new Course(102, "Applications of ICT", 3, cs);
        courses.add(oop);
        courses.add(ict);

        Address addr = new Address("Street 5", "Abbottabad", "KPK", "22010");

        UserAccount profAcc1 = new UserAccount(201, "ayesha", "ayesha123", "PROFESSOR");
        UserAccount profAcc2 = new UserAccount(202, "sana", "sana123", "PROFESSOR");

        Professor p1 = new Professor(1, "Maam Ayesha", "ayesha@university.edu", cs, profAcc1);
        Professor p2 = new Professor(2, "Maam Sana", "sana@university.edu", cs, profAcc2);
        professors.add(p1);
        professors.add(p2);

        UserAccount acc1 = new UserAccount(101, "mujtaba148", "pass123", "STUDENT");
        UserAccount acc2 = new UserAccount(102, "ilham001", "ilham123", "STUDENT");
        UserAccount acc3 = new UserAccount(103, "maryum002", "maryum123", "STUDENT");
        UserAccount acc4 = new UserAccount(104, "tayyaba003", "tayyaba123", "STUDENT");

        Student s1 = new Student(148, "Muhammad Mujtaba Bashar", "mujtaba@cuiatd.com", "03126222515", addr, acc1);
        Student s2 = new Student(1, "Ilham", "ilham@cuiatd.com", "03000000001", addr, acc2);
        Student s3 = new Student(2, "Maryum", "maryum@cuiatd.com", "03000000002", addr, acc3);
        Student s4 = new Student(3, "Tayyaba", "tayyaba@cuiatd.com", "03000000003", addr, acc4);

        studentRepo.add(s1);
        studentRepo.add(s2);
        studentRepo.add(s3);
        studentRepo.add(s4);

        allPeople.addAll(studentRepo.getAll());
        allPeople.addAll(professors);

        Grade g1 = new Grade(1, 148, oop, 88.5f);
        Grade g2 = new Grade(2, 148, ict, 92.0f);
        Grade g3 = new Grade(3, 1, oop, 91.0f);

        grades.add(g1);
        grades.add(g2);
        grades.add(g3);

        s1.getTranscript().addGrade(g1);
        s1.getTranscript().addGrade(g2);
        s2.getTranscript().addGrade(g3);

        Assessment a1 = new Assessment(1, "OOP Assignment 1", "ASSIGNMENT", oop, 20.0f);
        Assessment q1 = new Assessment(2, "OOP Quiz 1", "QUIZ", oop, 10.0f);
        assessments.add(a1);
        assessments.add(q1);

        records.add(new AssessmentRecord(1, s1, a1, 18.5f, "Graded"));
        records.add(new AssessmentRecord(2, s1, q1, 9.0f, "Graded"));
    }

    public static DataStore getInstance() {
        if (instance == null) instance = new DataStore();
        return instance;
    }

    public UserAccount authenticate(String u, String p) {
        if (u.equalsIgnoreCase("admin") && p.equals("admin123")) {
            return new UserAccount(0, "admin", "admin123", "ADMIN");
        }

        for (Person person : allPeople) {
            if (person.getAccount() != null && person.getAccount().login(u, p)) {
                return person.getAccount();
            }
        }
        return null;
    }
}

// ==========================================
// 4. GUI WINDOW FRAMES (EXTENDING BASE FRAME)
// ==========================================

class LoginFrame extends BaseFrame {
    private JTextField userField;
    private JPasswordField passField;

    public LoginFrame() {
        super("University Management System - Login", 480, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel wrapper = new JPanel(new BorderLayout(0, 14));
        wrapper.setBackground(bgOffWhite);

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 0, 4));
        headerPanel.setBackground(bgOffWhite);

        JLabel titleLabel = new JLabel("CAMPUS PORTAL LOGIN", SwingConstants.CENTER);
        titleLabel.setFont(fontTitle);
        titleLabel.setForeground(primaryNavy);

        JLabel subtitleLabel = new JLabel("Sign in to access courses, attendance, and records", SwingConstants.CENTER);
        subtitleLabel.setFont(fontSubtitle);
        subtitleLabel.setForeground(mutedText);

        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);
        wrapper.add(headerPanel, BorderLayout.NORTH);

        JPanel card = createCardPanel(new GridLayout(4, 1, 8, 8));

        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(fontLabel);
        lblUser.setForeground(primaryNavy);

        userField = new JTextField();
        userField.setFont(fontTable);

        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(fontLabel);
        lblPass.setForeground(primaryNavy);

        passField = new JPasswordField();
        passField.setFont(fontTable);

        card.add(lblUser);
        card.add(userField);
        card.add(lblPass);
        card.add(passField);

        wrapper.add(card, BorderLayout.CENTER);

        JButton btnLogin = createStyledButton("Login to Portal", accentBlue);
        btnLogin.setPreferredSize(new Dimension(200, 42));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setBackground(bgOffWhite);
        btnPanel.add(btnLogin);
        wrapper.add(btnPanel, BorderLayout.SOUTH);

        ActionListener loginAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u = userField.getText().trim();
                String p = new String(passField.getPassword()).trim();

                UserAccount acc = DataStore.getInstance().authenticate(u, p);
                if (acc != null) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Welcome back, " + acc.getUsername() + "!");
                    new DashboardFrame(acc).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        btnLogin.addActionListener(loginAction);
        passField.addActionListener(loginAction);

        return wrapper;
    }
}

class DashboardFrame extends BaseFrame {
    private UserAccount currentUser;

    public DashboardFrame(UserAccount account) {
        super("University Management System - Dashboard", 880, 560);
        this.currentUser = account;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel wrapper = new JPanel(new BorderLayout(0, 16));
        wrapper.setBackground(bgOffWhite);

        JPanel banner = createCardPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("CAMPUS DASHBOARD");
        titleLabel.setFont(fontTitle);
        titleLabel.setForeground(primaryNavy);

        JLabel roleLabel = new JLabel(currentUser.getUsername().toUpperCase() + "  •  " + currentUser.getRole());
        roleLabel.setFont(fontLabel);
        roleLabel.setForeground(accentBlue);

        banner.add(titleLabel, BorderLayout.WEST);
        banner.add(roleLabel, BorderLayout.EAST);
        wrapper.add(banner, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(4, 2, 14, 14));
        gridPanel.setBackground(bgOffWhite);

        JButton btnStudents = createStyledButton("Student Directory", primaryNavy);
        JButton btnCourses = createStyledButton("Course Catalog", primaryNavy);
        JButton btnProfessors = createStyledButton("Faculty Members", primaryNavy);
        JButton btnAttendance = createStyledButton("Attendance Tracker", accentBlue);
        JButton btnAssessments = createStyledButton("Assignments & Quizzes", accentBlue);
        JButton btnTranscript = createStyledButton("Academic Transcript", successGreen);
        JButton btnLogout = createStyledButton("Logout", dangerRed);

        gridPanel.add(btnStudents);
        gridPanel.add(btnCourses);
        gridPanel.add(btnProfessors);
        gridPanel.add(btnAttendance);
        gridPanel.add(btnAssessments);
        gridPanel.add(btnTranscript);
        gridPanel.add(btnLogout);

        wrapper.add(gridPanel, BorderLayout.CENTER);

        btnStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentFrame().setVisible(true);
            }
        });

        btnCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CourseFrame().setVisible(true);
            }
        });

        btnProfessors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfessorFrame().setVisible(true);
            }
        });

        btnAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AttendanceFrame(currentUser).setVisible(true);
            }
        });

        btnAssessments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssessmentFrame(currentUser).setVisible(true);
            }
        });

        btnTranscript.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TranscriptFrame(currentUser).setVisible(true);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });

        return wrapper;
    }
}

class StudentFrame extends BaseFrame {
    public StudentFrame() {
        super("Student Directory", 840, 480);
        initUI();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel card = createCardPanel(new BorderLayout(0, 12));

        JLabel heading = new JLabel("Registered Students");
        heading.setFont(fontTitle);
        heading.setForeground(primaryNavy);
        card.add(heading, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Role", "Email", "Phone", "Address"}, 0);
        JTable table = new JTable(model);
        styleTable(table);

        List<Student> list = DataStore.getInstance().studentRepo.getAll();
        for (Student s : list) {
            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getRoleTitle(),
                    s.getEmail(),
                    s.getPhone(),
                    s.getAddress().toString()
            });
        }

        card.add(new JScrollPane(table), BorderLayout.CENTER);
        return card;
    }
}

class CourseFrame extends BaseFrame {
    public CourseFrame() {
        super("Course Catalog", 740, 440);
        initUI();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel card = createCardPanel(new BorderLayout(0, 12));

        JLabel heading = new JLabel("Available Courses");
        heading.setFont(fontTitle);
        heading.setForeground(primaryNavy);
        card.add(heading, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Title", "Credits", "Department"}, 0);
        JTable table = new JTable(model);
        styleTable(table);

        for (Course c : DataStore.getInstance().courses) {
            model.addRow(new Object[]{c.getCourseId(), c.getTitle(), c.getCredits(), c.getDepartment().getName()});
        }

        card.add(new JScrollPane(table), BorderLayout.CENTER);
        return card;
    }
}

class ProfessorFrame extends BaseFrame {
    public ProfessorFrame() {
        super("Faculty Directory", 740, 440);
        initUI();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel card = createCardPanel(new BorderLayout(0, 12));

        JLabel heading = new JLabel("Faculty Members");
        heading.setFont(fontTitle);
        heading.setForeground(primaryNavy);
        card.add(heading, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Role / Department", "Email"}, 0);
        JTable table = new JTable(model);
        styleTable(table);

        for (Professor p : DataStore.getInstance().professors) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getRoleTitle(),
                    p.getEmail()
            });
        }

        card.add(new JScrollPane(table), BorderLayout.CENTER);
        return card;
    }
}

final class AttendanceFrame extends BaseFrame {
    private DefaultTableModel model;
    private JTable table;
    private UserAccount currentUser;

    public AttendanceFrame(UserAccount currentUser) {
        super("Attendance Management", 820, 500);
        this.currentUser = currentUser;
        initUI();
        refreshData();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel card = createCardPanel(new BorderLayout(0, 12));

        JLabel heading = new JLabel("Student Attendance Tracker");
        heading.setFont(fontTitle);
        heading.setForeground(primaryNavy);
        card.add(heading, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Student ID", "Name", "Email", "Attendance %"}, 0);
        table = new JTable(model);
        styleTable(table);
        card.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 6));
        bottomPanel.setBackground(cardWhite);

        JButton btnMarkPresent = createStyledButton("Mark Present", successGreen);
        JButton btnMarkAbsent = createStyledButton("Mark Absent", dangerRed);

        if (currentUser != null && "STUDENT".equalsIgnoreCase(currentUser.getRole())) {
            btnMarkPresent.setVisible(false);
            btnMarkAbsent.setVisible(false);
        }

        bottomPanel.add(btnMarkPresent);
        bottomPanel.add(btnMarkAbsent);
        card.add(bottomPanel, BorderLayout.SOUTH);

        btnMarkPresent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAttendance(true);
            }
        });

        btnMarkAbsent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAttendance(false);
            }
        });

        return card;
    }

    private void handleAttendance(boolean present) {
        int row = table.getSelectedRow();
        if (row >= 0) {
            int studentId = (int) model.getValueAt(row, 0);
            Student s = DataStore.getInstance().studentRepo.findById(studentId);
            if (s != null) {
                s.markAttendance(present);
                refreshData();
                JOptionPane.showMessageDialog(this, s.getName() + " marked " + (present ? "Present" : "Absent") + ".");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student row first.");
        }
    }

    @Override
    public void refreshData() {
        model.setRowCount(0);
        List<Student> list = DataStore.getInstance().studentRepo.getAll();

        for (Student s : list) {
            if (currentUser != null && "STUDENT".equalsIgnoreCase(currentUser.getRole())) {
                if (s.getAccount() != null && s.getAccount().getUsername().equalsIgnoreCase(currentUser.getUsername())) {
                    model.addRow(new Object[]{s.getId(), s.getName(), s.getEmail(), String.format("%.1f%%", s.getAttendancePercentage())});
                    break;
                }
            } else {
                model.addRow(new Object[]{s.getId(), s.getName(), s.getEmail(), String.format("%.1f%%", s.getAttendancePercentage())});
            }
        }
    }
}

final class AssessmentFrame extends BaseFrame {
    private DefaultTableModel model;
    private JTable table;
    private UserAccount currentUser;

    public AssessmentFrame(UserAccount currentUser) {
        super("Assignments, Quizzes & Marks Portal", 880, 500);
        this.currentUser = currentUser;
        initUI();
        refreshData();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel card = createCardPanel(new BorderLayout(0, 12));

        JLabel heading = new JLabel("Assignments & Quizzes");
        heading.setFont(fontTitle);
        heading.setForeground(primaryNavy);
        card.add(heading, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Record ID", "Student Name", "Assessment Title", "Type", "Status", "Obtained Marks"}, 0);
        table = new JTable(model);
        styleTable(table);
        card.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 6));
        bottomPanel.setBackground(cardWhite);

        JButton btnNewAssessment = createStyledButton("Add New Quiz/Assignment", successGreen);
        JButton btnUpdateMarks = createStyledButton("Upload/Update Marks", accentBlue);

        if (currentUser != null && "STUDENT".equalsIgnoreCase(currentUser.getRole())) {
            btnNewAssessment.setVisible(false);
            btnUpdateMarks.setVisible(false);
        }

        bottomPanel.add(btnNewAssessment);
        bottomPanel.add(btnUpdateMarks);
        card.add(bottomPanel, BorderLayout.SOUTH);

        btnNewAssessment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog(AssessmentFrame.this, "Enter Assessment Title:");
                if (title == null || title.trim().isEmpty()) return;

                String[] types = {"QUIZ", "ASSIGNMENT"};
                String type = (String) JOptionPane.showInputDialog(
                        AssessmentFrame.this,
                        "Select Type:",
                        "Assessment Type",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        types,
                        types[0]
                );
                if (type == null) return;

                String marksStr = JOptionPane.showInputDialog(AssessmentFrame.this, "Enter Total Marks:");
                if (marksStr == null) return;

                try {
                    float totalMarks = Float.parseFloat(marksStr.trim());
                    DataStore ds = DataStore.getInstance();
                    int newId = ds.assessments.size() + 1;
                    Course defaultCourse = ds.courses.get(0);
                    Assessment newAssess = new Assessment(newId, title.trim(), type, defaultCourse, totalMarks);
                    ds.assessments.add(newAssess);

                    for (Student s : ds.studentRepo.getAll()) {
                        int recId = ds.records.size() + 1;
                        ds.records.add(new AssessmentRecord(recId, s, newAssess, 0.0f, "Pending"));
                    }
                    refreshData();
                    JOptionPane.showMessageDialog(AssessmentFrame.this, "Added \"" + title.trim() + "\" for all students.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AssessmentFrame.this, "Please enter a valid number for total marks.");
                }
            }
        });

        btnUpdateMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    AssessmentRecord rec = DataStore.getInstance().records.get(row);
                    String input = JOptionPane.showInputDialog(
                            AssessmentFrame.this,
                            "Enter Marks out of " + rec.getAssessment().getTotalMarks() + ":"
                    );
                    if (input != null) {
                        try {
                            float marks = Float.parseFloat(input.trim());
                            if (marks < 0 || marks > rec.getAssessment().getTotalMarks()) {
                                JOptionPane.showMessageDialog(AssessmentFrame.this, "Marks must be between 0 and " + rec.getAssessment().getTotalMarks() + ".");
                                return;
                            }
                            rec.updateMarks(marks);
                            refreshData();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(AssessmentFrame.this, "Invalid number format!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(AssessmentFrame.this, "Please select a record.");
                }
            }
        });

        return card;
    }

    @Override
    public void refreshData() {
        model.setRowCount(0);
        for (AssessmentRecord r : DataStore.getInstance().records) {
            if (currentUser != null && "STUDENT".equalsIgnoreCase(currentUser.getRole())) {
                if (r.getStudent().getAccount() != null && r.getStudent().getAccount().getUsername().equalsIgnoreCase(currentUser.getUsername())) {
                    model.addRow(new Object[]{r.getRecordId(), r.getStudent().getName(), r.getAssessment().getTitle(), r.getAssessment().getType(), r.getStatus(), r.getObtainedMarks()});
                }
            } else {
                model.addRow(new Object[]{r.getRecordId(), r.getStudent().getName(), r.getAssessment().getTitle(), r.getAssessment().getType(), r.getStatus(), r.getObtainedMarks()});
            }
        }
    }
}

class TranscriptFrame extends BaseFrame {
    private DefaultTableModel model;
    private JTable table;
    private JLabel studentNameLabel;
    private JComboBox<Student> studentSelector;
    private UserAccount currentUser;

    public TranscriptFrame(UserAccount currentUser) {
        super("Official Academic Transcript", 820, 500);
        this.currentUser = currentUser;
        initUI();
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel card = createCardPanel(new BorderLayout(0, 12));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 4));
        topPanel.setBackground(cardWhite);

        studentNameLabel = new JLabel("Student Transcript:");
        studentNameLabel.setFont(fontTitle);
        studentNameLabel.setForeground(primaryNavy);
        topPanel.add(studentNameLabel);

        if (currentUser != null && !"STUDENT".equalsIgnoreCase(currentUser.getRole())) {
            studentSelector = new JComboBox<>();
            studentSelector.setFont(fontTable);
            for (Student s : DataStore.getInstance().studentRepo.getAll()) {
                studentSelector.addItem(s);
            }
            topPanel.add(studentSelector);

            studentSelector.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student sel = (Student) studentSelector.getSelectedItem();
                    if (sel != null) loadTranscript(sel);
                }
            });
        }

        card.add(topPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Course ID", "Course Title", "Credits", "Score", "Grade Letter"}, 0);
        table = new JTable(model);
        styleTable(table);
        card.add(new JScrollPane(table), BorderLayout.CENTER);

        if (currentUser != null && "STUDENT".equalsIgnoreCase(currentUser.getRole())) {
            for (Student s : DataStore.getInstance().studentRepo.getAll()) {
                if (s.getAccount() != null && s.getAccount().getUsername().equalsIgnoreCase(currentUser.getUsername())) {
                    studentNameLabel.setText("Transcript — " + s.getName());
                    loadTranscript(s);
                    break;
                }
            }
        } else if (!DataStore.getInstance().studentRepo.getAll().isEmpty()) {
            loadTranscript(DataStore.getInstance().studentRepo.getAll().get(0));
        }

        return card;
    }

    private void loadTranscript(Student s) {
        model.setRowCount(0);
        if (s != null && s.getTranscript() != null) {
            for (Grade g : s.getTranscript().getGrades()) {
                model.addRow(new Object[]{g.getCourse().getCourseId(), g.getCourse().getTitle(), g.getCourse().getCredits(), g.getScore(), g.getGradeLetter()});
            }
        }
    }
}

// ==========================================
// 5. APPLICATION ENTRY POINT
// ==========================================

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
