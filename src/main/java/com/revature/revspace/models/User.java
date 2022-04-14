package com.revature.revspace.models;


import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.revspace.util.UserSerializer;

import lombok.Data;


@Entity
@Table(name="users")
@JsonSerialize(using = UserSerializer.class)
public class User
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id", updatable=false, nullable = false, unique=true)
	private int userId;

	@Column(name="email", length=100, nullable=false, unique=true)
	private String email;

	@Column(name="first_name", length=50, nullable = false)
	private String firstName;

	@Column(name="last_name", length=50, nullable = false)
	private String lastName;
	
	@Column (name="image")
	private String image;

	@Column(name="birthday")
	private Long birthday;

	@Column(name="revature_join_date")
	private Long revatureJoinDate;

	@Column(name="github_username", length=50, nullable=false)
	private String githubUsername;

	@Column(name="title", length=100, nullable=false)
	private String title;

	@Column(name="location", length=500, nullable=false)
	private String location;

	@Column(name="aboutme", length=1000, nullable = false)
	private String aboutMe;
	
	@OneToMany(mappedBy="userReceive", fetch=FetchType.EAGER)
	@JsonBackReference
	private List<Notifications> notifications;
	
	@ManyToMany
    @JoinTable(name = "followers", joinColumns = @JoinColumn(name = "followerId"), inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> followers;
    
    @ManyToMany
    @JoinTable(name = "followers", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "followerId"))
    private List<User> following;

    public User() {
		this("", "", "","", null, null, "", "", "", "");
	}
	

	public User(int userId, String email, String firstName, String lastName,String image, Long birthday, Long revatureJoinDate,
			String githubUsername, String title, String location, String aboutMe, List<User> followers,
			List<User> following) {
		super();
		this.userId = userId;
	}
	
	public User(String email, String firstName, String lastName, Long birthday, Long revatureJoinDate, 
			String githubUsername, String title, String location, String aboutMe, List<User> followers, 
			List<User> following) {
		
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.revatureJoinDate = revatureJoinDate;
		this.githubUsername = githubUsername;
		this.title = title;
		this.location = location;
		this.aboutMe = aboutMe;
		this.followers = followers;
		this.following = following;
	}

	public User(String email, String firstName, String lastName, String image, Long birthday, Long revatureJoinDate, String githubUsername, String title, String location, String aboutMe)
	{
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.birthday = birthday;
		this.revatureJoinDate = revatureJoinDate;
		this.githubUsername = githubUsername;
		this.title = title;
		this.location = location;
		this.aboutMe = aboutMe;

	}


	public User(int userId, String email, String firstName, String lastName, String image, Long birthday, Long revatureJoinDate, String githubUsername, String title, String location, String aboutMe)
	{
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.birthday = birthday;
		this.revatureJoinDate = revatureJoinDate;
		this.githubUsername = githubUsername;
		this.title = title;
		this.location = location;
		this.aboutMe = aboutMe;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Long getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Long birthday)
	{
		this.birthday = birthday;
	}

	public Long getRevatureJoinDate()
	{
		return revatureJoinDate;
	}

	public void setRevatureJoinDate(Long revatureJoinDate)
	{
		this.revatureJoinDate = revatureJoinDate;
	}

	public String getGithubUsername()
	{
		return githubUsername;
	}

	public void setGithubUsername(String githubUsername)
	{
		this.githubUsername = githubUsername;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getAboutMe()
	{
		return aboutMe;
	}

	public void setAboutMe(String aboutMe)
	{
		this.aboutMe = aboutMe;
	}
	

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public List<User> getFollowing() {
		return following;
	}
	
	
	public void setFollowing(List<User> following) {
		this.following = following;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(aboutMe, other.aboutMe) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(followers, other.followers) && Objects.equals(following, other.following)
				&& Objects.equals(githubUsername, other.githubUsername) && Objects.equals(image, other.image)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(location, other.location)
				&& Objects.equals(notifications, other.notifications)
				&& Objects.equals(revatureJoinDate, other.revatureJoinDate) && Objects.equals(title, other.title)
				&& userId == other.userId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(aboutMe, birthday, email, firstName, followers, following, githubUsername, image, lastName,
				location, notifications, revatureJoinDate, title, userId);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", image=" + image + ", birthday=" + birthday + ", revatureJoinDate=" + revatureJoinDate
				+ ", githubUsername=" + githubUsername + ", title=" + title + ", location=" + location + ", aboutMe="
				+ aboutMe + ", notifications=" + notifications + ", followers=" + followers + ", following=" + following
				+ "]";
	}


	

    
}


