package test.Task.service;

import test.Task.dto.UserDTO;

/***
 * Interface that has the following method for working with UserDTO
 */
public interface IUserService {
    /***
     *
     * @param id - account id
     * @return user which was found by id in DB
     */
    UserDTO getUserByID(long id);
}
