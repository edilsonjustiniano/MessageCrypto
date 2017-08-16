package br.com.edilson.justiniano.message.crypto.dao;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for {@link GenericDao}
 */
@RunWith(MockitoJUnitRunner.class)
public class GenericDaoTest {

	@Mock
	private EntityManager entityManager;

	@InjectMocks
	private GenericDao<Object, Long> genericDao;

	@Test
	public void save_shouldCallPersist() {

		// given
		Object entity = new Object();
		doNothing().when(entityManager).persist(entity);

		// when
		genericDao.save(entity);

		// then
		verify(entityManager).persist(entity);
	}

	@Test
	public void update_shouldCallMerge() {

		// given
		Object entity = new Object();
		given(entityManager.merge(entity)).willReturn(entity);

		// when
		genericDao.update(entity);

		// then
		verify(entityManager).merge(entity);
	}

	@Test
	public void delete_shouldCallRemove() {

		// given
		Object entity = new Object();
		doNothing().when(entityManager).remove(entity);

		// when
		genericDao.delete(entity);

		// then
		verify(entityManager).remove(entity);
	}
}
