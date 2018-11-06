package com.soccer.service.impl;

import com.soccer.model.Manager;
import com.soccer.repository.ClubRepository;
import com.soccer.repository.ManagerRepository;
import com.soccer.repository.PlayerRepository;
import com.soccer.service.convert.RequestConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

/**
 * Created by karte on 10/2/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class SoccerServiceImplTest {

    @InjectMocks
    private SoccerServiceImpl soccerService;

    @Mock
    private ManagerRepository managerRepository;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private ClubRepository clubRepository;

    @Mock
    private RequestConverter requestConverter;

    private static ArrayList<Manager> managerArrayList = new ArrayList<>();

    @Before
    public void beforeStep() {
        Manager manager = new Manager();
        manager.setManager_id(10);
        managerArrayList.add(manager);
    }
    @Test
    public void getAllManagersTest() {
        when(managerRepository.findAll()).thenReturn(managerArrayList);
        Assert.assertEquals(soccerService.getAllManagers().get(0), managerArrayList.get(0));
    }
}
