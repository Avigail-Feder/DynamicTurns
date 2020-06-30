package entites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import controllers.MessageController;

public class DB {

	// ------------------Users------------------------
	public static HashSet<User> users = new HashSet<>();

	public static User getUser(String password, String firstName, String lastName) {
		User user = DB.users.stream().filter(u -> u.getPassword().equals(password)
				&& u.getFirst_name().equals(firstName) && u.getLast_name().equals(lastName)).findAny().orElse(null);
		return user;

	}

	public static HashSet<User> getUsers() {
		return users;
	}

	public static void setUsers(HashSet<User> users) {
		DB.users = users;
	}

	public static BooleanResponse update(User user) {
		System.out.println(user.getId());
		User existsUser = DB.users.stream().filter(u -> u.getId().equals(user.getId())).findAny().orElse(null);
		System.out.println(existsUser);
		if (existsUser != null) {
			existsUser.setFirst_name(user.getFirst_name());
			existsUser.setLast_name(user.getLast_name());
			existsUser.setAddress(user.getAddress());
			existsUser.setEmail(user.getEmail());
			existsUser.setTelephone(user.getTelephone());
		} else
			DB.addUser(user);
		return new BooleanResponse(true);
	}

	public static BooleanResponse isExistUser(String password, String first, String last) {
		return new BooleanResponse(users.stream().filter(item -> item.getPassword().equals(password)
				&& item.getFirst_name().equals(first) && item.getLast_name().equals(last)).findAny().orElse(null) != null);
	}

	public static BooleanResponse isManager(String password, String firstName, String lastName) {
		return new BooleanResponse(DB.users.stream()
				.filter(item -> item.getFirst_name().equals(firstName) && item.getLast_name().equals(lastName)
						&& item.getPassword().equals(password) && item.getIsManager().equals(true))
				.findAny().orElse(null) != null);
	}

	// add user
	public static BooleanResponse addUser(User u) {
		System.out.println("in add user");
		System.out.println(u.getPassword());
		if (getUserById(u.id) == null) {
			System.out.println("אין כזה תז אז כעת נוסיף");
			return new BooleanResponse(users.add(u));

		}
		return new BooleanResponse(false);
	}

	// public static BooleanResponse updateUser(User user) {
	// User u = DB.users.stream().filter(item -> item.getId() ==
	// user.getId()).findAny().orElse(null);
	// if (user == null) {
	// users.remove(u);
	// users.add(user);
	//
	// }
	// return new BooleanResponse(u != null);
	//
	// }
	// �?חיקת �?שת�?ש �?הרשי�?ה
	public static BooleanResponse delete(String id) {
		User user = users.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
		System.out.println(user);
		return new BooleanResponse(users.remove(user));
	}

	public static BooleanResponse deleteUser(UserId id) {
		return new BooleanResponse(
				users.remove(users.stream().filter(item -> item.getId().equals(id.getId())).findAny().get()));
	}

	public static User getUserById(String id) {
		User user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return user;
	}

	// ---------Destinations------------------------

	public static HashSet<Destination> destinations = new HashSet<>();

	public static HashSet<Destination> getDestinations() {
		return destinations;
	}

	public static Destination getNameById(String id) {
		Destination dest = destinations.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
		return dest;
	}

	public static void setDestinations(HashSet<Destination> destinations) {

	}
	// -----------Meetings---------------------------------

	public static List<Meeting> meetings = new ArrayList<Meeting>();

	public static List<Meeting> GetById(String id) {
		List<Meeting> destinationMeetings = meetings.stream().filter(item -> item.getDestId().equals(id))
				.collect(Collectors.toList());
		System.out.println("meetings after filter");
		destinationMeetings.forEach(m -> {
			System.out.println(m);
		});
		return destinationMeetings;
	}

	public static List<Meeting> getMeetingsByUserId(String id) {
		List<Meeting> userMeetings = meetings.stream().filter(item -> item.getCustomerId().equals(id))
				.collect(Collectors.toList());
		System.out.println("meetings after filter");
		userMeetings.forEach(m -> {
			System.out.println(m);
		});
		return userMeetings;
	}

	public static List<Meeting> getMeetings() {
		System.out.println("in getMeetings!!!!!!!!!!");
		meetings.forEach(m -> System.out.println(m));
		return meetings;
	}
	// ---------------------Requests--------------------------

	public static List<Request> requests = new ArrayList<Request>();
	// -----------------------Message----------------------------
	public static List<Message> messages = new ArrayList<Message>();

	public static List<Message> getMessages() {
		return messages;
	}

	public static BooleanResponse addMessage(Message message) {
		System.out.println("in the db!");
		message.setCode(messages.size() + 1);
		return new BooleanResponse(messages.add(message));
	}

	// -----------static----------------------------------
	static {
		users.add(new User("Nava", "Eisenstein", "0583227457", "p.t", "11", "n0583227457@gmail.com", "1", true));
		users.add(new User("1", "1", "1", "p.t", "1", "n0583227457@gmail.com", "1", false));
		users.add(new User("Avigail", "Feder", "0548494053", "PT", "315163659", "a0548494053@gmail.com", "1", false));
		users.add(new User("Michal", "Feder", "0548415655", "PT", "322653023", "m0548415655@gmail.com", "1", false));
		users.add(new User("2", "2", "2", "pt", "2", "mail", "2", false));
		destinations.add(new Destination("1", "Shulamit", "Eisenstion", "shulamit@gmail.com", "Doctor"));
		destinations.add(new Destination("2", "Efrat", "Eisenstion", "shulamit@gmail.com", "security"));

		meetings.add(
				new Meeting(1, "theFirstMeeting", (LocalDateTime.now().minusHours(5)), LocalDateTime.now(), "1", "1"));
		meetings.add(
				new Meeting(3, "theThirdMeeting", (LocalDateTime.now().minusHours(5)), LocalDateTime.now(), "1", "1"));
		
		
		
		
		meetings.add(
				new Meeting(2, "theSecondMeeting", LocalDateTime.now(), LocalDateTime.now().plusHours(3), "1", "2"));
		messages.add(new Message(1, "1", "hi! what's up?😀?😂?"));
		messages.add(new Message(2, "315163659", "everything is ok b'h"));
	}

}
