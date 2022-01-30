/*
Freeware License, some rights reserved

Copyright (c) 2018 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.apress.bgn.nine.fake.db;

import com.apress.bgn.nine.Account;
import com.apress.bgn.nine.db.DBException;
import com.apress.bgn.nine.db.DbConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public class FakeDBConnection implements DbConnection {
    /**
     * pseudo-database {@code Map<holder, Account>}
     */
    Map<String, Account> database = new HashMap<>();

    @Override
    public void connect() {
        // no implementation needed
    }

    @Override
    public Account insert(Account account) {
        if (database.containsKey(account.getHolder())) {
            throw new DBException("Could not insert " + account);
        }
        database.put(account.getHolder(), account);
        return account;
    }

    @Override
    public Account findByHolder(String holder) {
        return database.get(holder);
    }

    @Override
    public List<Account> findAll() {
        List<Account> result = new ArrayList<>();
        result.addAll(database.values());
        return result;
    }

    @Override
    public Account update(Account account) {
        if (!database.containsKey(account.getHolder())) {
            throw new DBException("Could not find account for " + account.getHolder());
        }
        database.put(account.getHolder(), account);
        return account;
    }

    @Override
    public void delete(String holder) {
        database.remove(holder);
    }

    @Override
    public void disconnect() {
        // no implementation needed
    }
}
