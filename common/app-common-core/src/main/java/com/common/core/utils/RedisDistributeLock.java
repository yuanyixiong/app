package com.common.core.utils;

import com.common.core.exception.TryGetLockFailExcetion;
import com.common.core.function.Operation;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


/**
 * @author 袁毅雄
 * @description Redis分布式锁
 * @date 2019/6/12
 */
@Service
public class RedisDistributeLock {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisDistributeLock.class);


    private static RedissonClient redissonClient;

    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        RedisDistributeLock.redissonClient = redissonClient;
    }


    /**
     * 尝试获取锁，最多等待 waitTime 时间
     * 注意：该方法获取的锁不会自动解锁，必须要调用 @see unLock 方法进行解锁
     *
     * @param key
     * @param waitTime
     * @param timeUnit
     * @return
     */
    public static boolean tryLock(String key, Long waitTime, TimeUnit timeUnit) {
        final RLock lock = redissonClient.getLock(key);
        try {
            return lock.tryLock(waitTime, timeUnit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 解锁Key
     *
     * @param key
     */
    public static void unLock(String key) {
        final RLock lock = redissonClient.getLock(key);
        lock.unlock();
    }


    /**
     * 尝试进行加锁，最多等待 waitTime 时间，持有锁到 leaseTime 后自动解锁
     *
     * @param key
     * @param waitTime
     * @param leaseTime
     * @param timeUnit
     * @return
     * @throws InterruptedException
     */
    public static boolean tryLock(String key, Long waitTime, Long leaseTime, TimeUnit timeUnit) throws InterruptedException {
        final RLock lock = redissonClient.getLock(key);
        return lock.tryLock(waitTime, leaseTime, timeUnit);
    }

    /**
     * 尝试进行加锁，最多等待 waitTime 时间，执行operation操作，然后进行解锁
     *
     * @param key
     * @param waitTime
     * @param timeUnit
     * @param operation
     * @throws TryGetLockFailExcetion
     */
    public static void tryLock(String key, Long waitTime, TimeUnit timeUnit, Operation operation) throws TryGetLockFailExcetion {
        final RLock lock = redissonClient.getLock(key);
        final boolean result;
        try {
            result = lock.tryLock(waitTime, timeUnit);
            if (result) {
                try {
                    operation.operation();
                } finally {
                    lock.unlock();
                }
            } else {
                throw new TryGetLockFailExcetion();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 尝试进行加锁，最多等待 waitTime 时间，执行sussessOperation操作，然后进行解锁,如果获取锁失败，则执行 failOperation 操作
     *
     * @param key
     * @param waitTime
     * @param timeUnit
     * @param sussessOperation
     * @param failOperation
     */
    public static void tryLock(String key, Long waitTime, TimeUnit timeUnit, Operation sussessOperation, Operation failOperation) {
        final RLock lock = redissonClient.getLock(key);
        final boolean result;
        try {
            result = lock.tryLock(waitTime, timeUnit);
            if (result) {
                try {
                    sussessOperation.operation();
                } finally {
                    lock.unlock();
                }
            } else {
                failOperation.operation();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 尝试进行加锁，最多等待 waitTime 时间，执行supplier操作，然后进行解锁
     *
     * @param key
     * @param waitTime
     * @param timeUnit
     * @param supplier
     * @param <R>
     * @return
     * @throws TryGetLockFailExcetion
     */
    public static <R> R tryLock(String key, Long waitTime, TimeUnit timeUnit, Supplier<R> supplier) throws TryGetLockFailExcetion {
        final RLock lock = redissonClient.getLock(key);
        try {
            final boolean result = lock.tryLock(waitTime, timeUnit);
            if (result) {
                try {
                    return supplier.get();
                } finally {
                    lock.unlock();
                }
            } else {
                throw new TryGetLockFailExcetion();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 尝试进行加锁，最多等待 waitTime 时间，执行sussessSupplier操作，然后进行解锁，获取锁失败则执行 failSupplier 操作
     *
     * @param key
     * @param waitTime
     * @param timeUnit
     * @param sussessSupplier
     * @param failSupplier
     * @param <R>
     * @return
     */
    public static <R> R tryLock(String key, Long waitTime, TimeUnit timeUnit, Supplier<R> sussessSupplier, Supplier<R> failSupplier) {
        final RLock lock = redissonClient.getLock(key);
        try {
            final boolean result = lock.tryLock(waitTime, timeUnit);
            if (result) {
                try {
                    return sussessSupplier.get();
                } finally {
                    lock.unlock();
                }
            } else {
                return failSupplier.get();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
