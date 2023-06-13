/*
 * PaidLeaveエンティティに対して基本的なCRUD (Create, Read, Update, Delete) 操作を提供するための
 * リポジトリインターフェースです。

CrudRepository<PaidLeave, Integer>を継承しているため、PaidLeaveエンティティの操作に関する一般的なメソッドが提供されます。
具体的には以下のようなメソッドが利用できます。

save(S entity): エンティティを保存または更新します。
findById(ID id): 指定されたIDに基づいてエンティティを取得します。
findAll(): すべてのエンティティを取得します。
deleteById(ID id): 指定されたIDに基づいてエンティティを削除します。
また、PaidLeaveRepositoryはPaidLeaveエンティティの操作を担当するため、
PaidLeaveテーブルに対するデータアクセスを行います。

このリポジトリインターフェースを使用することで、PaidLeaveエンティティに関するデータベース操作を簡単に実行できます。


*/

package com.plma.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.plma.model.entity.PaidLeave;

public interface PaidLeaveRepository extends CrudRepository<PaidLeave, Integer> {

}
