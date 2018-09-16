package annotation;

public enum AuthorName {

	SRIKANTH("Srikanth Tangudu");

	private String authorName;

	AuthorName(String authorName) {

		this.authorName = authorName;

	}

	public String toString() {

		return this.authorName;

	}

}
