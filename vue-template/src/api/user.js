import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/user/login',
    method: 'post',
    params: {
      username,
      password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'post',
    params: {
      token
    }
  })
}

export function logout(token) {
  return request({
    url: '/user/logout',
    method: 'post',
    params: {
      token
    }
  })
}

export function checkName(username) {
  return request({
    url: '/user/checkname',
    method: 'post',
    params: {
      username
    }
  })
}

export function register(username, password) {
  return request({
    url: '/user/register',
    method: 'post',
    params: {
      username,
      password
    }
  })
}