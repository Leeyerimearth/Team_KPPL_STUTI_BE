package prgrms.project.stuti.global.error.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

	//common
	INVALID_METHOD_ARGUMENT("C001", "Invalid method argument", HttpStatus.BAD_REQUEST),
	UNKNOWN_SERVER_ERROR("S001", "Unknown server error", HttpStatus.INTERNAL_SERVER_ERROR),

	//study group
	INVALID_STUDY_PERIOD("SG001", "Invalid study period", HttpStatus.BAD_REQUEST),
	NOT_FOUND_STUDY_GROUP("SG002", "Not found study group", HttpStatus.NOT_FOUND),
	NOT_STUDY_LEADER("SG003", "Not study leader", HttpStatus.BAD_REQUEST),
	EXISTING_STUDY_GROUP_MEMBER("SG004", "Existing study group member", HttpStatus.BAD_REQUEST),
	NOT_FOUND_STUDY_GROUP_MEMBER("SG005", "Not found study group member", HttpStatus.NOT_FOUND),
	NOT_FOUND_STUDY_GROUP_QUESTION("SG006", "Not found study group question", HttpStatus.NOT_FOUND),
	NOT_MATCH_WRITER("SG007", "Not match writer", HttpStatus.BAD_REQUEST),
	NOT_MATCH_STUDY_GROUP("SG008", "Not match study group", HttpStatus.BAD_REQUEST),
	RECRUITMENT_IS_CLOSED("SG009", "Recruitment is closed", HttpStatus.BAD_REQUEST),

	//file
	EMPTY_FILE("F001", "Uploaded empty file", HttpStatus.BAD_REQUEST),
	UNSUPPORTED_EXTENSION("F002", "Unsupported file extension", HttpStatus.UNSUPPORTED_MEDIA_TYPE),
	OVER_MAX_SIZE("F003", "Over max size", HttpStatus.PAYLOAD_TOO_LARGE),
	FAILED_RESIZE("F004", "Failed to resize image file", HttpStatus.SERVICE_UNAVAILABLE),
	FAILED_UPLOAD("F005", "Failed to upload image file", HttpStatus.SERVICE_UNAVAILABLE),
	FAILED_DELETE("F006", "Failed to delete image file", HttpStatus.SERVICE_UNAVAILABLE),

	// Member
	TOKEN_EXPIRATION("M001", "Token is expired", HttpStatus.BAD_REQUEST),
	BLACKLIST_DETECTION("M002", "AccessToken is deprived", HttpStatus.BAD_REQUEST),
	INVALID_EMAIL("M003", "Email is invalid", HttpStatus.BAD_REQUEST),
	NOT_FOUND_MEMBER("M004", "Not found member", HttpStatus.BAD_REQUEST),
	NICKNAME_DUPLICATION("M005", "Nickname Duplication", HttpStatus.BAD_REQUEST),
	REGISTERED_MEMBER("M006", "Member is already registered", HttpStatus.BAD_REQUEST),
	NOT_MATCH_MY_PAGE_MEMBER("M007", "Not match with my page member", HttpStatus.BAD_REQUEST),

	//post
	POST_NOT_FOUND("P001", "not exist post", HttpStatus.BAD_REQUEST),
	POST_LIKE_DUPLICATED("F002", "already liked this post", HttpStatus.BAD_REQUEST),
	NOT_FOUND_POST_LIKE("F003","not found feed like", HttpStatus.BAD_REQUEST),

	//(post)comment
	PARENT_POST_COMMENT_NOT_FOUND("FC001", "parent comment not exist", HttpStatus.BAD_REQUEST),
	POST_COMMENT_NOT_FOUND("FC002", "not exist comment", HttpStatus.BAD_REQUEST);

	private final String code;
	private final String message;
	private final HttpStatus httpStatus;

	ErrorCode(String code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
}
